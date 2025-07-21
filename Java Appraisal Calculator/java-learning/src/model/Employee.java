package model;

public class Employee {
    private String name;
    private String id;
    private int ticketsClosed;
    private int disciplinaryActions;
    private int ticketsRemaining;

    private double selfReview;
    private double managerReview;
    private double coworkerReview;

    private double innovation;
    private double punctuality;
    private double currentSalaryLPA;

    private String joiningDate;
    private String arrivalTime;

    // Setters
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setTicketsClosed(int ticketsClosed) { this.ticketsClosed = ticketsClosed; }
    public void setDisciplinaryActions(int disciplinaryActions) { this.disciplinaryActions = disciplinaryActions; }
    public void setTicketsRemaining(int ticketsRemaining) { this.ticketsRemaining = ticketsRemaining; }

    public void setSelfReview(double selfReview) { this.selfReview = selfReview; }
    public void setManagerReview(double managerReview) { this.managerReview = managerReview; }
    public void setCoworkerReview(double coworkerReview) { this.coworkerReview = coworkerReview; }

    public void setInnovation(double innovation) { this.innovation = innovation; }
    public void setPunctuality(double punctuality) { this.punctuality = punctuality; }
    public void setCurrentSalaryLPA(double currentSalaryLPA) { this.currentSalaryLPA = currentSalaryLPA; }

    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    // Getters (Optional, if needed in AppraisalService)
    public String getName() { return name; }
    public String getId() { return id; }
    public int getTicketsClosed() { return ticketsClosed; }
    public int getDisciplinaryActions() { return disciplinaryActions; }
    public int getTicketsRemaining() { return ticketsRemaining; }

    public double getSelfReview() { return selfReview; }
    public double getManagerReview() { return managerReview; }
    public double getCoworkerReview() { return coworkerReview; }

    public double getInnovation() { return innovation; }
    public double getPunctuality() { return punctuality; }
    public double getCurrentSalaryLPA() { return currentSalaryLPA; }

    public String getJoiningDate() { return joiningDate; }
    public String getArrivalTime() { return arrivalTime; }
}
