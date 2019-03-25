package jnegmas.apps.scml.simulators;

import jnegmas.PyCaller;
import jnegmas.apps.scml.common.Job;

import java.util.ArrayList;

public class PythonFactorySimulator extends PyCaller<FactorySimulator> implements FactorySimulator {
    public PythonFactorySimulator(){
        super();
    }
    public PythonFactorySimulator(FactorySimulator pythonObject){
        super(pythonObject);
    }

    @Override
    public Integer maxStorage() {
        return shadow.maxStorage();
    }

    @Override
    public int nSteps() {
        return shadow.nSteps();
    }

    @Override
    public double initialWallet() {
        return shadow.initialWallet();
    }

    @Override
    public ArrayList<Integer> initialStorage() {
        return shadow.initialStorage();
    }

    @Override
    public int nLines() {
        return shadow.nLines();
    }

    @Override
    public double finalBalance() {
        return shadow.finalBalance();
    }

    @Override
    public ArrayList<Double> walletTo(int t) {
        return shadow.walletTo(t);
    }

    @Override
    public double walletAt(int t) {
        return shadow.walletAt(t);
    }

    @Override
    public ArrayList<Integer> storageTo(int t) {
        return shadow.storageTo(t);
    }

    @Override
    public ArrayList<Integer> storageAt(int t) {
        return shadow.storageAt(t);
    }

    @Override
    public ArrayList<Integer> lineSchedulesTo(int t) {
        return shadow.lineSchedulesTo(t);
    }

    @Override
    public ArrayList<Integer> lineSchedulesAt(int t) {
        return shadow.lineSchedulesAt(t);
    }

    @Override
    public ArrayList<Integer> totalStorageTo(int t) {
        return shadow.totalStorageTo(t);
    }

    @Override
    public int totalStorageAt(int t) {
        return shadow.totalStorageAt(t);
    }

    @Override
    public ArrayList<Integer> reservedStorageTo(int t) {
        return shadow.reservedStorageTo(t);
    }

    @Override
    public ArrayList<Integer> reservedStorageAt(int t) {
        return shadow.reservedStorageAt(t);
    }

    @Override
    public ArrayList<Integer> availableStorageAt(int t) {
        return shadow.availableStorageAt(t);
    }

    @Override
    public ArrayList<Integer> availableStorageTo(int t) {
        return shadow.availableStorageTo(t);
    }

    @Override
    public ArrayList<Double> loansTo(int t) {
        return shadow.loansTo(t);
    }

    @Override
    public double loansAt(int t) {
        return shadow.loansAt(t);
    }

    @Override
    public double balanceAt(int t) {
        return shadow.balanceAt(t);
    }

    @Override
    public ArrayList<Double> balanceTo(int t) {
        return shadow.balanceTo(t);
    }

    @Override
    public int fixedBefore() {
        return shadow.fixedBefore();
    }

    @Override
    public void setState(int t, ArrayList<Integer> storage, double wallet, double loans, ArrayList<Integer> lineSchedules) {
        shadow.setState(t, storage, wallet, loans, lineSchedules);
    }

    @Override
    public boolean addLoan(double total, int t) {
        return shadow.addLoan(total, t);
    }

    @Override
    public boolean receive(double payment, int t) {
        return shadow.receive(payment, t);
    }

    @Override
    public boolean pay(double payment, int t, boolean ignoreMoneyShortage) {
        return shadow.pay(payment, t, ignoreMoneyShortage);
    }

    @Override
    public boolean transportTo(int product, int quantity, int t, boolean ignoreInventoryShortage, boolean ignoreSpaceShortage) {
        return shadow.transportTo(product, quantity, t, ignoreInventoryShortage, ignoreSpaceShortage);
    }

    @Override
    public boolean buy(int product, int quantity, int price, int t, boolean ignoreMoneyShortage, boolean ignoreSpaceShortage) {
        return shadow.buy(product, quantity, price, t, ignoreMoneyShortage, ignoreSpaceShortage);
    }

    @Override
    public boolean sell(int product, int quantity, int price, int t, boolean ignoreMoneyShortage, boolean ignoreInventoryShortage) {
        return shadow.sell(product, quantity, price, t, ignoreMoneyShortage, ignoreInventoryShortage);
    }

    @Override
    public boolean schedule(Job job, boolean ignoreInventoryShortage, boolean ignoreMoneyShortage, boolean ignoreSpaceShortage, boolean override) {
        return shadow.schedule(job, ignoreInventoryShortage, ignoreMoneyShortage, ignoreSpaceShortage, override);
    }

    @Override
    public boolean reserve(int product, int quantity, int t) {
        return shadow.reserve(product, quantity, t);
    }

    @Override
    public boolean fixBefore(int t) {
        return shadow.fixBefore(t);
    }

    @Override
    public int bookmark() {
        return shadow.bookmark();
    }

    @Override
    public boolean rollback(int bookmarkId) {
        return shadow.rollback(bookmarkId);
    }

    @Override
    public boolean deleteBookmark(int bookmarkId) {
        return shadow.deleteBookmark(bookmarkId);
    }
}
