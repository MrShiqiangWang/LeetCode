package pkg202007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class L811 {

    public static void main(String[] args) {
        String[] cpdomains = { "9001 discuss.leetcode.com" };
        System.out.println(new L811().subdomainVisits(cpdomains));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainMap = new HashMap<String, Integer>();
        for (String domain : cpdomains) {
            String[] domainVisits = domain.split(" ");
            int visit = Integer.parseInt(domainVisits[0]);
            String[] subDomains = domainVisits[1].split("\\.");
            String key = subDomains[subDomains.length - 1];
            domainMap.put(key, domainMap.getOrDefault(key, 0) + visit);
            for (int i = subDomains.length - 2; i >= 0; i--) {
                key = subDomains[i] + "." + key;
                domainMap.put(key, domainMap.getOrDefault(key, 0) + visit);
            }
        }
        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        for (Entry<String, Integer> entry : domainMap.entrySet()) {
            builder.append(entry.getValue());
            builder.append(" ");
            builder.append(entry.getKey());
            result.add(builder.toString());
            builder = new StringBuilder();
        }
        return result;
    }
}
