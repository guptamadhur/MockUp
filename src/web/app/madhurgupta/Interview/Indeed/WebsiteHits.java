package web.app.madhurgupta.Interview.Indeed;

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "5,com.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts) =>
com:                     1345
google.com:              900
stackoverflow.com:       10
overflow.com:            20
yahoo.com:               410
mail.yahoo.com:          60
mobile.sports.yahoo.com: 10
sports.yahoo.com:        50
com.com:                 5
org:                     3
wikipedia.org:           3
en.wikipedia.org:        2
m.wikipedia.org:         1
mobile.sports:           1
sports:                  1
uk:                      1
co.uk:                   1
google.co.uk:            1

n: number of domains in the input
(individual domains and subdomains have a constant upper length)
*/

public class WebsiteHits {
  static HashMap<String, Integer> domainMap = new HashMap<>();

  public static void main(String[] argv) {
    String[] counts = {
        "900,google.com",
        "60,mail.yahoo.com",
        "10,mobile.sports.yahoo.com",
        "40,sports.yahoo.com",
        "300,yahoo.com",
        "10,stackoverflow.com",
        "20,overflow.com",
        "5,com.com",
        "2,en.wikipedia.org",
        "1,m.wikipedia.org",
        "1,mobile.sports",
        "1,google.co.uk"
    };
    WebsiteHits.getDomainHits(counts);
    domainMap.entrySet().forEach(domain -> {
      System.out.println(" " + domain.getKey() + " " + domain.getValue());
      // System.out.println("key:"+ domain.getKey() + " Hits:"+ domain.getValue());
    });
  }

  static void getDomainHits(String[] counts) {
    domainMap = new HashMap<>();
    for (int i = 0; i < counts.length; i++) {
      String[] countDomain = counts[i].split(",");
      int count = Integer.parseInt(countDomain[0]);
      if (countDomain[1].length() > 0) {
        String[] subDomains = countDomain[1].split("\\.");
        pushToMap(subDomains, countDomain[1], count);
      }
    }
  }

  static void pushToMap(String[] subDomainList, String fullDomain, int hits) {
    if (fullDomain.length() > 0 && hits > 0 && subDomainList.length > 0) {
      if (domainMap.containsKey(fullDomain)) {
        int domainHits = domainMap.remove(fullDomain);
        domainMap.put(fullDomain, (domainHits + hits));
      } else {
        domainMap.put(fullDomain, hits);
      }
      String[] newDomainList = ArrayUtils.remove(subDomainList, 0);
      String newFullDomain = String.join(".", newDomainList);
      pushToMap(newDomainList, newFullDomain, hits);
    }
  }
}
