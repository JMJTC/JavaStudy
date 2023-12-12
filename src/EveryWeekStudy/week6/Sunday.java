package EveryWeekStudy.week6;

/**
 * @author jmjtc
 */
public class Sunday {

    class Trie{
        Trie[] children;
        boolean isEnd;
        public Trie(){
            this.isEnd=false;
            this.children=new Trie[26];
        }
        public  void insert(String word){
            int i,n=word.length();
            Trie trie=this;
            for(i=0;i<n;i++){
                int post=word.charAt(i)-'a';
                if(trie.children[post]==null){

                }
            }
        }
    }


}
