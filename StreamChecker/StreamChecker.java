package StreamChecker;

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord;
}

public class StreamChecker {
    TrieNode root = new TrieNode();
    int len = 0;
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] arr) {
        createTrie(arr);
    }

    public boolean query(char letter) {
        if (sb.length() < len)
            sb.append(letter);
        else {
            sb.deleteCharAt(0);
            sb.append(letter);
        }
        System.out.println(sb);

        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (node != null && node.next[sb.charAt(i) - 'a'] != null) {
                node = node.next[sb.charAt(i) - 'a'];
                if (node.isWord == true)
                    return true;
            } else
                return false;
        }
        return false;

    }

    private void createTrie(String[] arr) {
        for (String s : arr) {
            len = Math.max(len, s.length());
            TrieNode node = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new TrieNode();
                }
                node = node.next[ch - 'a'];
            }
            node.isWord = true;
        }
    }
}
