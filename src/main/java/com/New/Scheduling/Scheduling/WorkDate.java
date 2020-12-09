package com.New.Scheduling.Scheduling;
import java.util.Collection;
import java.util.HashMap;
public class WorkDate {
	READ code= new READ();
    private Integer day;
    private HashMap<Integer, Shift> shifts = new HashMap<Integer, Shift>(7);
    

    
    public WorkDate(int i) {
        this();
        day = i;
    }


    public WorkDate() {
        for (int i = 1; i <= code.getCode1(); i++) {
            this.addShift(new Shift(i));
        }
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer d) {
        day = d;
    }

    /**
     * 填充一个班次
     * @param s
     */
    public void addShift(Shift s) {
        s.setWorkDate(this);
        shifts.put(s.getNo(), s);
    }

    public Collection<Shift> getShifts() {
        return shifts.values();
    }

    /**
     *     当前日历是否已有Worker
     * @param w
     * @return
     */
    public boolean containsWorker(Worker w) {
        for (Shift s : this.getShifts()) {
            if (s.containsWorker(w)) {
                return true;
            }
        }
        return false;
    }
    public boolean containsWorker1(Worker w) {
        for (Shift s : this.getShifts()) {
            if (s.containsWorker(w)) {
                return true;
            }
        }
        return false;
    }
}

