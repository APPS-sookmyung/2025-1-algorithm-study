import java.io.*;
import java.util.*;

/**
 * 각 기타가 연주 가능한 곡을 비트마스크(long 타입)로 저장
 * 1개부터 guitarCount개까지의 모든 기타 조합을 DFS로 시도
 * 각 조합에서 연주 가능한 곡의 수를 계산하고, 최대값 갱신
 * 최종적으로 필요한 최소 기타 수 출력
 *
 * 각 조합에서:
 *
 * 1. 선택된 기타들이 연주할 수 있는 곡들을 OR 연산으로 합침
 * 2. 합쳐진 비트에서 1의 개수(Long.bitCount)가 연주 가능한 곡의 수
 * 3. 이 수가 이전까지의 최대값보다 크면 업데이트
 */
public class prompt {
    static int guitarCount, songCount;          // 기타 수(N), 곡 수(M)
    static long[] possibleSongs;                // 각 기타가 연주 가능한 곡을 비트마스크로 저장
    static boolean[] isSelected;                // 기타 선택 여부 체크 배열
    static int minGuitarNeeded,maxPlayableSongs;                // 연주 가능한 최대 곡 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        guitarCount = Integer.parseInt(st.nextToken());
        songCount = Integer.parseInt(st.nextToken());

        possibleSongs = new long[guitarCount];
        isSelected = new boolean[guitarCount];

        // 각 기타별 연주 가능한 곡 정보 입력받기
        for (int i = 0; i < guitarCount; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();  // 기타 이름은 사용하지 않음
            String songInfo = st.nextToken();

            // Y인 경우 해당 비트를 1로 설정
            for (int j = 0; j < songCount; j++) {
                if (songInfo.charAt(j) == 'Y') {
                    possibleSongs[i] |= (1L << j);
                }
            }
        }

        minGuitarNeeded = Integer.MAX_VALUE;
        maxPlayableSongs = 0;

        // 1개부터 guitarCount개까지 기타 조합 시도
        for (int i = 1; i <= guitarCount; i++) {
            dfs(0, i);
        }

        System.out.println(minGuitarNeeded == Integer.MAX_VALUE ? -1 : minGuitarNeeded);
    }

    static void dfs(int start, int count) {
        if (count == 0) {  // 기타를 다 골랐을 때
            int selectedCount = 0;  // 선택된 기타 수
            long totalSongs = 0;    // 선택된 기타들로 연주 가능한 모든 곡

            // 선택된 기타들의 연주 가능 곡 합치기
            for (int i = 0; i < guitarCount; i++) {
                if (isSelected[i]) { //선택된 기타들만 확인 
                    selectedCount++;
                    totalSongs |= possibleSongs[i]; // 연주 가능한 곡들 합치기  
                }
            }

            // 연주 가능한 곡이 더 많아지면 업데이트
            if (Long.bitCount(totalSongs) > maxPlayableSongs) {
                maxPlayableSongs = Long.bitCount(totalSongs);
                minGuitarNeeded = selectedCount;
            }
            return;
        }

        //백트래킹
        // 기타 선택하기: 재귀 호출: start 부터 시작해서 기타 선택 
        for (int i = start; i < guitarCount; i++) {
            if (!isSelected[i]) {//아직 선택되지 않은 기타라면 
                isSelected[i] = true; //기타 선택
                dfs(i + 1, count - 1); //다음 기타 선택하러 가기 
                isSelected[i] = false; //기타 선택 취소 
            }
        }
    }
}