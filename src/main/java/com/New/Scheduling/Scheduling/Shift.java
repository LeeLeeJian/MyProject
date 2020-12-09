package com.New.Scheduling.Scheduling;


public class Shift  implements Comparable<Shift> {
    private Integer no;
    private WorkDate workDate;   
    private Worker custoM;
    private Worker workeR;
    public Shift() {
    }

    public Shift(int i) {
        no = i;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer i) {
        no = i;
    }

    public WorkDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(WorkDate d) {
        workDate = d;
    }
    
    public Worker getCustoM() {
        return custoM;
    }

    public void setCustoM(Worker w) {
    	custoM = w;
    }
    
    public Worker getWorkeR() {
        return workeR;
    }

    public void setWorkeR(Worker w) {
    	workeR = w;
    }
    /**
     *查询当前班次是否已有woker
     * @param w
     * @return
     */
    public boolean containsWorker(Worker w) {
        return workeR == w ;
    }

    public boolean isDone() {
        return workeR != null ;
    }
    
    
    public boolean containsWorker1(Worker w) {
        return custoM == w ;
    }

    public boolean isDone1() {
        return custoM != null;
    }
    
    public int compareTo(Shift shift) {
        int a = this.getWorkDate().getDay() * 10 + no;
        int b = shift.getWorkDate().getDay() * 10 + shift.getNo();
        return a - b;
    }
}

