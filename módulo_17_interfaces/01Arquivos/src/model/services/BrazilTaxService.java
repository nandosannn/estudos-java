package model.services;

public class BrazilTaxService implements TaxServer{
    //Method
    @Override
	public Double tax(Double amount){
        if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
    }
}
