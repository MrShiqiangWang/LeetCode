package package_in_201906;

public class DetectCapitalUse {

    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'z');

        System.out.println(new DetectCapitalUse().detectCapitalUse("isA"));
    }

    public boolean detectCapitalUse(String word) {
        char[] words = word.toCharArray();
        if (words.length <= 1) {
            return true;
        }

        if (words[0] < 123 && words[0] > 96) {
            // 剩下的也必须是小�?
            for (int i = 1; i < words.length; i++) {
                if (words[i] < 91 && words[i] > 64) {
                    return false;
                }
            }
        }

        if (words[0] < 91 && words[0] > 64) {
            // 全部是小�?
            // 全部是大�?
            Boolean captial = null;
            for (int i = 1; i < words.length; i++) {
                // 大写
                if (words[i] < 91 && words[i] > 64) {
                    if (captial == null) {
                        captial = true;
                    }
                    else {
                        if (captial == false) {
                            return false;
                        }
                    }
                }
                if (words[i] < 123 && words[i] > 96) {
                    if (captial == null) {
                        captial = false;
                    }
                    else {
                        if (captial == true) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
