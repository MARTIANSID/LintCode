import java.util.*;
class FrequencyTracker {

  HashMap<Integer,Integer> valuesMap;
  HashMap<Integer,Integer> freqMap;

  public FrequencyTracker() {
      this.valuesMap=new HashMap<>();
      this.freqMap=new HashMap<>();
  }

  public void add(int number) {
      valuesMap.put(number,valuesMap.getOrDefault(number,0)+1);
      int freq=valuesMap.get(number);
      if(freq>1){
       freqMap.put(freq-1,freqMap.get(freq-1)-1);
       if(freqMap.get(freq-1)==0)freqMap.remove(freq-1);
      }
      freqMap.put(freq,freqMap.getOrDefault(freq, 0)+1);
  }

  public void deleteOne(int number) {
      if(!valuesMap.containsKey(number))return;
      int freq=valuesMap.get(number);
      if(freq == 1)valuesMap.remove(number);
      else valuesMap.put(number,freq-1);
      freqMap.put(freq,freqMap.get(freq)-1);
      if(freqMap.get(freq)==0)freqMap.remove(freq);
      if(freq-1>0)
      freqMap.put(freq-1,freqMap.getOrDefault(freq-1, 0)+1);
  }

  public boolean hasFrequency(int frequency) {
      return freqMap.containsKey(frequency);
  }
}
/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */