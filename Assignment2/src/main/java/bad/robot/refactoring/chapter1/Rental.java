package main.java.bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

	double getChargeForRental() {
		double amount = 0;
		switch (getMovie().getPriceCode()) {
		    case Movie.REGULAR:
		        amount += 2;
		        if (getDaysRented() > 2)
		            amount += (getDaysRented() - 2) * 1.5;
		        break;
		    case Movie.NEW_RELEASE:
		        amount += getDaysRented() * 3;
		        break;
		    case Movie.CHILDREN:
		        amount += 1.5;
		        if (getDaysRented() > 3)
		            amount += (getDaysRented() - 3) * 1.5;
		        break;
		}
		return amount;
	}

	int calculateFrequentRenterPoints() {
		// add frequent renter points
		// add bonus for a two day new release rental
		if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
		    return 2;
		return 1;
	}

}
