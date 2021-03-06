package com.gen.sword.offer;

/**
 * 实现字典树的增删改查
 * @author Genge
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        if (word == null){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null){
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word){
        if (search(word)){
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.map[index].path-- == 1){
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }

    public boolean search(String word){
        if (word == null){
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null){
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNumber(String pre){
        if (pre == null){
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null){
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }
}
