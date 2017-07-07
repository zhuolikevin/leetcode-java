/*
 * [535] Encode and Decode TinyURL
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl
 *
 * Medium (73.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * Can you solve this problem? 🤔
 */
public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private String host = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.substring(19));
        return map.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
