class Solution {
    class Runner {
        String key;
        int value;
        Runner next;

        Runner(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class CustomHashMap {
        private final int SIZE = 1000;
        private Runner[] entry = new Runner[SIZE];

        private int hash(String key) {
            int hash = 0;
            for (char c : key.toCharArray()) {
                hash = (hash * 31 + c) % SIZE;
            }
            return hash;
        }

        public void put(String key, int value) {
            int index = hash(key);
            Runner current = entry[index];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            Runner newEntry = new Runner(key, value);
            newEntry.next = entry[index];
            entry[index] = newEntry;
        }

        public int get(String key) {
            int index = hash(key);
            Runner current = entry[index];

            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }

            return 0;
        }

        public void increment(String key) {
            int index = hash(key);
            Runner current = entry[index];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value++;
                    return;
                }
                current = current.next;
            }

            put(key, 1);
        }

        public void decrement(String key) {
            int index = hash(key);
            Runner current = entry[index];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value--;
                    return;
                }
                current = current.next;
            }
        }

        public String finding() {
            for (int i = 0; i < SIZE; i++) {
                Runner current = entry[i];
                while (current != null) {
                    if (current.value != 0) {
                        return current.key;
                    }
                    current = current.next;
                }
            }
            return null;
        }
    }

    public String solution(String[] participant, String[] completion) {
        CustomHashMap map = new CustomHashMap();

        for (String p : participant) {
            map.increment(p);
        }

        for (String c : completion) {
            map.decrement(c);
        }

        return map.finding();
    }
}
// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         String answer = "";
//         boolean[] visited = new boolean[completion.length];
        
//         for(String p:participant){
//             boolean check = false;
//             for(int i=0; i<completion.length; i++){
//                 if(!visited[i] && p.equals(completion[i])){
//                     visited[i]=true;
//                     check =true;
//                     break;
//                 }
//             }
//             if(!check)
//                 answer = p;
//         }
        
//         return answer;
//     }
// }