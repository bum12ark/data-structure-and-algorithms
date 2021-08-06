package part2.sort.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 파일 정리 */
public class BOJ_20291 {
    static class File implements Comparable<File> {
        String name; // 이름
        String extension; // 확장자

        public File(String name, String extension) {
            this.name = name;
            this.extension = extension;
        }

        @Override
        public int compareTo(File others) {
            return extension.compareTo(others.extension);
        }

        @Override
        public String toString() {
            return "[" + this.name + ", " + this.extension + "]";
        }
    }

    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static File[] files;

    static void input() {
        N = fastReader.nextInt();
        files = new File[N];
        for (int index = 0; index < N; index++) {
            String fileName = fastReader.next();
            int dotIndex = fileName.indexOf("."); // . 의 위치
            String name = fileName.substring(0, dotIndex); // 파일 이름
            String extension = fileName.substring(dotIndex + 1); // 확장자

            files[index] = new File(name, extension);
        }
    }

    static void process() {
        // 파일 정렬
        Arrays.sort(files);

        // 파일의 개수 출력
        int currentCount = 1;
        for (int index = 1; index < N; index++) {
            String currentExtension = files[index].extension;
            String prevExtension = files[index - 1].extension;
            if (currentExtension.equals(prevExtension)) {
                currentCount += 1;
            } else {
                sb.append(prevExtension).append(" ").append(currentCount).append("\n");
                currentCount = 1;
            }
        }
        sb.append(files[N - 1].extension).append(" ").append(currentCount);

        // 정답 출력
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
