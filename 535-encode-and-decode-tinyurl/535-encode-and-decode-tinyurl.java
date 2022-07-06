public class Codec {
    
    HashMap<String,String> encodeUrl;
    HashMap<String,String> decodeUrl;
    String base;
    
    Codec(){
        this.encodeUrl=new HashMap<>();
        this.decodeUrl=new HashMap<>();
        this.base="http://sid.com/";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(encodeUrl.containsKey(longUrl))return encodeUrl.get(longUrl);
        String encodedUrl=base+encodeUrl.size();
        encodeUrl.put(longUrl,encodedUrl);
        decodeUrl.put(encodedUrl,longUrl);
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeUrl.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));