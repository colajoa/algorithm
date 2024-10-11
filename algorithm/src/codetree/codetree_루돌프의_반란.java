package codetree;

import java.io.*;
import java.util.*;

public class codetree_루돌프의_반란 {
    static int N, M, P, C, D, RR, RC, Time = 0;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static Santa[] santas;
    static int[][] board;
    static long[] score;
    static boolean[][] visited;
    static class Santa implements Comparable<Santa>{
        int r, c, time;
        
        public Santa(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        public int compareTo(Santa santa) {
            if(calcDis(this.r, this.c, RR, RC) == calcDis(santa.r, santa.c, RR, RC)) {
                if(this.r == santa.r) {
                    return santa.c - this.c;
                }
                return santa.r - this.r;
            }

            return calcDis(this.r, this.c, RR, RC) - calcDis(santa.r, santa.c, RR, RC);
        }
    }
    static boolean checkAlive() {
        int death = 0;
        for(int p = 1; p < P + 1; p++) {
            if(santas[p].time == -1) {
                death += 1;
            } else if(santas[p].time < Time) {
                santas[p].time = Time;
            }
        }

        if(death == P) {
            return false;
        }

        return true;
    }

    static void print(String str) {
        System.out.println(str);
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(r == RR && c == RC) {
                    System.out.print("R ");
                } else {
                    System.out.print(board[r][c] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void moveRu() {
        List<Santa> distance = new ArrayList<>();
        for(int i = 1; i < P + 1; i++) {
            // 탈락 산타 검사
            if(santas[i].time != -1) {
                distance.add(santas[i]);
            }    
        }

        // 거리 정렬
        Collections.sort(distance);

        Santa santa = distance.get(0);
        int dir = -1;
        int min = calcDis(santa.r, santa.c, RR, RC);

        for(int d = 0; d < 8; d++) {
            int nr = RR + dr[d];
            int nc = RC + dc[d];

            if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                int dis = calcDis(santa.r, santa.c, nr, nc);
                if(min > dis) {
                    min = dis;
                    dir = d;
                }
            }
        }

        // 루돌프 위치 조정
        RR = RR + dr[dir];
        RC = RC + dc[dir];

        // 충돌 체크
        if(board[RR][RC] != 0) {
            // 루돌프가 이동한 위치의 산타번호
            int idx = board[RR][RC];
            // 루돌프 이동 위치 0으로 변경
            board[RR][RC] = 0;

            // 충돌한 산타 점수 추가
            score[idx] += C;

            // 산타 C만큼 밀려남
            santas[idx].r = santas[idx].r + (dr[dir] * C);
            santas[idx].c = santas[idx].c + (dc[dir] * C);
            
            // 산타 기절
            santas[idx].time = Time + 2;

            // 현재 위치
            int nr = santas[idx].r;
            int nc = santas[idx].c;
            
            // 충돌 후 상호작용
            while(true) {

                // 이동한 곳이 범위 밖이면 산타 탈락 후 종료
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    santas[idx].time = -1;
                    break;
                }

                // 이동하는 칸이 빈칸일 경우 이동 후 종료
                else if(board[nr][nc] == 0) {
                    board[nr][nc] = idx;
                    break;
                }

                // 산타 만나면 상호작용
                else if(board[nr][nc] != 0) {
                    // 이동한 곳의 산타 번호
                    int now = board[nr][nc];
                    // 이동한 곳에 이전 산타 착지
                    board[nr][nc] = idx;
                    // 이동하는 산타 번호 변경
                    idx = now;
                    
                    // 현재 위치를 다음 이동할 위치로 변경
                    nr += dr[dir];
                    nc += dc[dir];
                    
                    // 이동한 곳에 있던 산타 좌표 변경
                    santas[idx].r = nr;
                    santas[idx].c = nc;
                }
            }
        }
    }

    // 산타 이동
    static void moveSanta() {
        // 순서대로 산타 이동
        for(int p = 1; p < P + 1; p++) {
            
            Santa santa = santas[p];
            // 탈락했거나 기절한 경우 이동 불가
            if(santa.time == -1 || santa.time > Time) continue;

            // 방향 설정
            int dir = -1;
            // 루돌프와 산타 거리 계산
            int min = calcDis(santa.r, santa.c, RR, RC);
            
            // 상우하좌 우선순위로 이동
            for(int d = 0; d < 8; d += 2) {
                int nr = santa.r + dr[d];
                int nc = santa.c + dc[d];
                
                // 범위 밖과 산타가 있는 곳은 이동 불가
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(board[nr][nc] != 0) continue;
                
                // 산타가 이동할 위치에서 루돌프와 거리 계산
                int dis = calcDis(nr, nc, RR, RC);

                // 이동하는 곳이 루돌프와 가까워지면 그 방향으로 설정
                if(min > dis) {
                    min = dis;
                    dir = d;
                }
            }
            
            // 이동
            if(dir != -1) {
                // 기존 산타 위치 비우기
                board[santa.r][santa.c] = 0;
                // 산타 좌표 변경
                santa.r = santa.r + dr[dir];
                santa.c = santa.c + dc[dir];

                // 이동하는 곳에 루돌프 있다면
                if(santa.r == RR && santa.c == RC) {
                    // 점수 획득
                    score[p] += D;
                    
                    // 진행방향 반대로 변경
                    dir = (dir + 4) % 8;
                    
                    // 반대로 D만큼 밀려남
                    santa.r = santa.r + (dr[dir] * D);
                    santa.c = santa.c + (dc[dir] * D);

                    // 산타 기절
                    santa.time = Time + 2;
                }

                // 현재 산타 위치;
                int nr = santa.r;
                int nc = santa.c;

                // 산타 이동 위치가 범위 밖이면 탈락
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    santa.time = -1;
                }

                // 빈칸일 경우 산타이동
                else if(board[nr][nc] == 0) {
                    board[nr][nc] = p;
                } 

                // 다른 산타와 충돌
                else if(board[nr][nc] != 0) {
                    // 이동한 위치의 산타 번호
                    int idx = board[nr][nc];
                    // 이동한 위치에 이동 중인 산타 안착
                    board[nr][nc] = p;
                    
                    // 이동한 위치의 산타 이동
                    santas[idx].r = santas[idx].r + dr[dir];
                    santas[idx].c = santas[idx].c + dc[dir];

                    // 현재 위치 변경
                    nr = santas[idx].r;
                    nc = santas[idx].c;
                    
                    // 상호 작용
                    while(true) {

                        // 범위 밖
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            santas[idx].time = -1;
                            break;
                        }
                        // 빈칸
                        else if(board[nr][nc] == 0) {
                            board[nr][nc] = idx;
                            break;
                        }

                        // 산타 있을 때
                        else if(board[nr][nc] != 0) {
                            // 현재 위치 산타
                            int now = board[nr][nc];
                            // 이동한 현재 위치의 산타를 이동 중인 산타로 교체
                            board[nr][nc] = idx;
                            // 이동 중인 산타를 이동한 현재 위치 산타로 교체
                            idx = now;
                            
                            // 이동 산타 위치 변경
                            nr += dr[dir];
                            nc += dc[dir];
                            santas[idx].r = nr;
                            santas[idx].c = nc;
                        }
                    }
                }
            }
        }
    }

    // 점수 계산
    static void scoring() {
        for(int p = 1; p < P + 1; p++) {
            if(santas[p].time != -1) {
                score[p] += 1;
            }
        }
    }

    // 거리 계산
    static int calcDis(int r1, int c1, int r2, int c2) {
        int rm = r1 - r2;
        int cm = c1 - c2;

        return (rm * rm) + (cm * cm);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());

        RR = Integer.parseInt(token.nextToken()) - 1;
        RC = Integer.parseInt(token.nextToken()) - 1;
        
        santas = new Santa[P + 1];
        score = new long[P + 1];
        board = new int[N][N];
        
        for(int p = 0; p < P; p++) {
            token = new StringTokenizer(br.readLine());

            int santa = Integer.parseInt(token.nextToken());
            int sr = Integer.parseInt(token.nextToken()) - 1;
            int sc = Integer.parseInt(token.nextToken()) - 1;

            board[sr][sc] = santa;
            santas[santa] = new Santa(sr, sc, 0);
        }

        while(Time < M) {
            moveRu();
            moveSanta();
            scoring();
            // 시간 증가
            Time++;
            // 탈락 체크 
            if(!checkAlive()) {
                break;
            }
        }

        for(int p = 1; p < P + 1; p++) {
            sb.append(score[p]).append(" ");
        }

        System.out.println(sb);
    }
}
