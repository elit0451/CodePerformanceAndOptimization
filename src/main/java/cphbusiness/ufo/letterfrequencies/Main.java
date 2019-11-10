package cphbusiness.ufo.letterfrequencies;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

/**
 * Frequency analysis Inspired by
 * https://en.wikipedia.org/wiki/Frequency_analysis
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "/letterfrequencies/src/main/resources/FoundationSeries.txt";
        char[] content = new String(Files.readAllBytes(Paths.get(fileName))).toCharArray();
        Map<Character, Long> freq = new HashMap<>();
        tallyChars(content, freq);
        //print_tally(freq);
    }

    private static void tallyChars(char[] content, Map<Character, Long> freq) throws IOException {
        for(char c: content){
            if(freq.containsKey(c))
                freq.put(c, freq.get(c) + 1);
            else
                freq.put(c, 1L);
            }
//        while ((b = reader.read()) != -1) {
//            try {
//                freq.put(b, freq.get(b) + 1);
//            } catch (NullPointerException np) {
//                freq.put(b, 1L);
//            };
//        }
    }

    private static void print_tally(Map<Character, Long> freq) {
        int dist = 'a' - 'A';
        Map<Character, Long> upperAndlower = new LinkedHashMap();
        for (Character c = 'A'; c <= 'Z'; c++) {
            upperAndlower.put(c, freq.getOrDefault(c, 0L) + freq.getOrDefault(c + dist, 0L));
        }
        Map<Character, Long> sorted = upperAndlower
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (Character c : sorted.keySet()) {
            System.out.println("" + c + ": " + sorted.get(c));;
        }
    }
}
