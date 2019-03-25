package jnegmas.apps.scml.simulators;

import jnegmas.PyCallable;
import jnegmas.apps.scml.common.Job;

import java.util.ArrayList;

public interface FactorySimulator extends PyCallable {

    Integer maxStorage();

    int nSteps();

    double initialWallet();

    ArrayList<Integer> initialStorage();

    int nLines();

    double finalBalance();

    ArrayList<Double> walletTo(int t);

    double walletAt(int t);

    ArrayList<Integer> storageTo(int t);

    ArrayList<Integer> storageAt(int t);

    ArrayList<Integer> lineSchedulesTo(int t);

    ArrayList<Integer> lineSchedulesAt(int t);

    ArrayList<Integer> totalStorageTo(int t);

    int totalStorageAt(int t);

    ArrayList<Integer> reservedStorageTo(int t);

    ArrayList<Integer> reservedStorageAt(int t);

    ArrayList<Integer> availableStorageAt(int t);

    ArrayList<Integer> availableStorageTo(int t);

    ArrayList<Double> loansTo(int t);

    double loansAt(int t);

    double balanceAt(int t);

    ArrayList<Double> balanceTo(int t);

    int fixedBefore();

    void setState(int t, ArrayList<Integer> storage, double wallet, double loans, ArrayList<Integer> lineSchedules);

    boolean addLoan(double total, int t);

    boolean receive(double payment, int t);

    boolean pay(double payment, int t, boolean ignoreMoneyShortage);

    boolean transportTo(int product, int quantity, int t, boolean ignoreInventoryShortage
            , boolean ignoreSpaceShortage);

    boolean buy(int product, int quantity, int price, int t, boolean ignoreMoneyShortage,
                boolean ignoreSpaceShortage);

    boolean sell(int product, int quantity, int price, int t, boolean ignoreMoneyShortage,
                 boolean ignoreInventoryShortage);

    boolean schedule(Job job, boolean ignoreInventoryShortage, boolean ignoreMoneyShortage
            , boolean ignoreSpaceShortage, boolean override);

    boolean reserve(int product, int quantity, int t);

    boolean fixBefore(int t);

    int bookmark();

    boolean rollback(int bookmarkId);

    boolean deleteBookmark(int bookmarkId);
}
