package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer() {

	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {

		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double salaryTax() {
		double monthlySalary = salaryIncome / 12;

		if (monthlySalary <= 3000.00) {
			return 0.0;
		} else if (monthlySalary <= 5000.00) {
			return this.salaryIncome * 10 / 100;
		} else {
			return this.salaryIncome * 20 / 100;
		}
	}

	public Double servicesTax() {
		if (this.servicesIncome > 0) {
			return this.servicesIncome * 15 / 100;
		} else {
			return 0.0;
		}
	}

	public Double capitalTax() {
		return (this.capitalIncome > 0) ? this.capitalIncome * 20 / 100 : 0.0;
	}

	public Double grossTax() {
		return this.salaryTax() + this.servicesTax() + this.capitalTax();
	}

	public Double taxRebate() {
		double maximumDeductible = 0.0;
		double deductibleExpenses = 0.0;

		maximumDeductible = this.grossTax() * 30 / 100;
		deductibleExpenses = this.healthSpending + this.educationSpending;

		if (deductibleExpenses > maximumDeductible) {
			return maximumDeductible;
		} else {
			return deductibleExpenses;
		}
	}

	public Double netTax() {
		return this.grossTax() - this.taxRebate();
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
}
