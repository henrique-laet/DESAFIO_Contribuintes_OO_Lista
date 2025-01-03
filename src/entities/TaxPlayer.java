package entities;

public class TaxPlayer {

    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPlayer() {
    }

    public TaxPlayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {      //imposto sobre salario
        double salaryMen = salaryIncome / 12;
        if (salaryMen < 3000) {
            return 0.0;
        } else if (salaryMen >= 3000 && salaryMen < 5000) {
            return salaryIncome * 0.10; // 10% de imposto
        } else {
            return salaryIncome * 0.20; // 20% de imposto
        }
    }

    public double servicesTax() {     //imposto sobre servico
        return servicesIncome * 0.15;
    }

    public double capitalTax() {    //imposto sobre capital
        return capitalIncome * 0.20;
    }

    public double grossTax() {     //imposto bruto
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {   //abatimento
        double gastosPessoais = healthSpending + educationSpending;
        if (grossTax() > gastosPessoais) {
            return gastosPessoais;
        } else {
            return grossTax() * 0.30;
        }
    }

    public double netTax() {    //imposto liquido
        return grossTax() - taxRebate();
    }


}

