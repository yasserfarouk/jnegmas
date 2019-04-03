package jnegmas.apps.scml.simulators;

import jnegmas.PyCallable;
import jnegmas.apps.scml.common.Job;

import java.util.List;

public interface FactorySimulator extends PyCallable {

    Integer maxStorage();

    int nSteps();

    double initialWallet();

    List<Integer> initialStorage();

    int nLines();

    double finalBalance();

    List<Double> walletTo(int t);

    double walletAt(int t);

    List<Integer> storageTo(int t);

    List<Integer> storageAt(int t);

    List<Integer> lineSchedulesTo(int t);

    List<Integer> lineSchedulesAt(int t);

    List<Integer> totalStorageTo(int t);

    int totalStorageAt(int t);

    List<Integer> reservedStorageTo(int t);

    List<Integer> reservedStorageAt(int t);

    List<Integer> availableStorageAt(int t);

    List<Integer> availableStorageTo(int t);

    List<Double> loansTo(int t);

    double loansAt(int t);

    double balanceAt(int t);

    List<Double> balanceTo(int t);

    int fixedBefore();

    void setState(int t, List<Integer> storage, double wallet, double loans, List<Integer> lineSchedules);

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
