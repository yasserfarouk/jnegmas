package jnegmas.apps.scml.simulators;

import jnegmas.apps.scml.common.Job;

import java.util.ArrayList;
import java.util.Optional;

public interface PySimulator {

    Optional<Integer> max_storage();

    int n_steps();

    double initial_wallet();

    ArrayList<Integer> initial_storage();

    int n_lines();

    double final_balance();

    ArrayList<Double> wallet_to(int t);

    double wallet_at(int t);

    ArrayList<Integer> storage_to(int t);

    ArrayList<Integer> storage_at(int t);

    ArrayList<Integer> line_schedules_to(int t);

    ArrayList<Integer> line_schedules_at(int t);

    ArrayList<Integer> total_storage_to(int t);

    int total_storage_at(int t);

    ArrayList<Integer> reserved_storage_to(int t);

    ArrayList<Integer> reserved_storage_at(int t);

    ArrayList<Integer> available_storage_at(int t);

    ArrayList<Integer> available_storage_to(int t);

    ArrayList<Double> loans_to(int t);

    double loans_at(int t);

    double balance_at(int t);

    ArrayList<Double> balance_to(int t);

    int fixed_before();

    void set_state(int t, ArrayList<Integer> storage, double wallet, double loans, ArrayList<Integer> line_schedules);

    boolean add_loan(double total, int t);

    boolean receive(double payment, int t);

    boolean pay(double payment, int t, boolean ignore_money_shortage);

    boolean transport_to(int product, int quantity, int t, boolean ignore_inventory_shortage
            , boolean ignore_space_shortage);

    boolean buy(int product, int quantity, int price, int t, boolean ignore_money_shortage,
                boolean ignore_space_shortage);

    boolean sell(int product, int quantity, int price, int t, boolean ignore_money_shortage,
                 boolean ignore_inventory_shortage);

    boolean schedule(Job job, boolean ignore_inventory_shortage, boolean ignore_money_shortage
            , boolean ignore_space_shortage, boolean override);

    boolean reserve(int product, int quantity, int t);

    boolean fix_before(int t);

    int bookmark();

    boolean rollback(int bookmark_id);

    boolean delete_bookmark(int bookmark_id);
}
