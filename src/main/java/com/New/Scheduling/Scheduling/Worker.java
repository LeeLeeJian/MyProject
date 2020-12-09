package com.New.Scheduling.Scheduling;
import java.util.Collection;
import java.util.HashMap;
public class Worker {
    private Integer type;
    private String name;
    private Integer dayShift = 0;
    private Integer nightShift = 0;
    private Integer maxDay = 0;
    private Integer easyDay;
    private HashMap<Integer, Shift> shifts = new HashMap<Integer, Shift>(30);
    
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public Worker() {
    }

    public Worker(int i, String n) {
        type = i;
        name = n;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer i) {
        type = i;
    }

    public Integer getEasyDay() {
        return easyDay;
    }

    public void setEasyDay(Integer i) {
        easyDay = i;
    }

    public Integer getDayShift() {
        return dayShift;
    }
    public Integer getNightShift() {
        return nightShift;
    }
    public Integer getMaxDay() {
        return maxDay;
    }
    /**
     * 计算连续工作天数以及连续白班夜班数
     * @param s
     */
    public void addShift(Shift s) {
        shifts.put(s.getWorkDate().getDay(), s);
        easyDay--;
        int m = 0;
        int n = 0;
        int l = 0;
        for (int i = 1; i <= 31; i++) {
            if (shifts.containsKey(i)) {
            	if (s.getNo()==1) {
                    m++;
                    dayShift = Math.max(dayShift, m);
                    n=0;
            	}
            	if (s.getNo()==2) {
                    n++;
                    nightShift = Math.max(nightShift, n);
                    m=0;
            	}
            	l++;
            	maxDay = Math.max(maxDay, l);

            } else {
                m = 0;
                n = 0;
                l = 0;
            }
        }
    }

    public Integer getShiftTotal() {
        return shifts.size();
    }

    public Collection<Shift> getShifts() {
        return shifts.values();
    }
}