/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alessandro Bisiani
 * @version v1.0 - 1 May 2015
 */
public class ExperimentData implements Serializable{
    
    //size is the number of episodes, it relates the number of the episode with the number of steps it took.
    private ArrayList<Integer> stepsXEpisode;
    
    //size is number of ep. Relates the episode w the normalized cumulative reward.
    private ArrayList<Double> ratioOfCumulativeRewards;
    
    //all q matrix data for every episode. Should probably not include the zeros.
    private ArrayList<double[][]> allData;
    
    private ArrayList<double[]> qValuesPerEpisode;
    
    private String policy;
    private double epsilon;
    private double gamma;
    private double alpha;
    private String goalState;
    private String initialState;
    private double temperatureRate;
    private String algorithm;
    
    public ExperimentData(int numStates, int numEpisodes){
        stepsXEpisode = new ArrayList<>();
        ratioOfCumulativeRewards = new ArrayList<>();
        allData = new ArrayList<>();
        qValuesPerEpisode = new ArrayList<>();
        gamma = 0.0;
        alpha = 0.0;
        temperatureRate = 0.0;
    }
    /**
     * Adds the number of steps executed in an episode to collected experiment data.
     * @param steps     Number of steps to reach the goal state that episode.
     */
    public void addSteps(int steps){
        stepsXEpisode.add(steps);
    }
    /**
     * Adds the cumulative weighted Q values in an episode to collected experiment data.
     * @param reward    The cumulative weighted Q values that episode.
     */
    public void addReward(double reward){
        ratioOfCumulativeRewards.add(reward);
    }
    /**
     * Adds the Q matrix at the end of an episode in its entirety to collected experiment data.
     * @param episode   All Q matrix entries that episode.
     */
    public void addEpisode(double[][] episode){
        allData.add(episode);
    }
    /**
     * Adds the updated Q values at the end of an episode to collected experiment data.
     * @param episodeQs     All updated Q values that episode.
     */
    public void addQValues(double[] episodeQs){
        qValuesPerEpisode.add(episodeQs);
    }
    /**
     * Resets the accumulated experiment data.
     */
    public void resetData(){
        ratioOfCumulativeRewards.removeAll(ratioOfCumulativeRewards);
        stepsXEpisode.removeAll(stepsXEpisode);
        allData = new ArrayList<>();
        qValuesPerEpisode = new ArrayList<>();
    }
    
    /**
     * Print the number of steps per episode and number of data points collected to the current output.
     */
    public void printSteps(){
        int s = stepsXEpisode.size();
        Integer[] steps = new Integer[s];
        stepsXEpisode.toArray(steps);
        for(int i=0;i<s;i++){
            System.out.println(steps[i]);
        }
        System.out.println("# Steps Data Points: "+s);
    }
    /**
     * Print the collected cumulative rewards and number of cumulative rewards collected to the current output.
     */
    public void printCumulativeRewards(){
        int s = ratioOfCumulativeRewards.size();
        Double[] rewards = new Double[s];
        ratioOfCumulativeRewards.toArray(rewards);
        for(int i=0;i<s;i++){
            System.out.println(rewards[i]);
        }
        System.out.println("# Cumulative rewards: "+s);
    }
    
    /**
     * Get the data collected on the number of steps taken per episode throughout the latest experiment.
     * @return      A list of steps taken per episode with index 0 corresponding to the first episode.
     */
    public ArrayList<Integer> getStepsXEpisode(){
        return stepsXEpisode;
    }
    /**
     * Get the data collected on amount of expected return (cumulative Q) per episode throughout the latest experiment.
     * @return      A list of cumulative weighted Q values per episode with index 0 corresponding to the first episode.
     */
    public ArrayList<Double> getRatioOfCumulativeRewards(){
        return ratioOfCumulativeRewards;
    }
    /**
     * Get the Q matrices collected at episode termination throughout the latest experiment.
     * @return      A list containing all Q matrices at the end of each episode, with index 0 corresponding to the first episode.
     */
    public ArrayList<double[][]> getAllData(){
        return allData;
    }
    /**
     * Get the updated Q values per episode throughout the latest experiment.
     * @return      A list containing updated Q values at the end of each episode, with index 0 corresponding to the first episode.
     */
    public ArrayList<double[]> getQValuesPerEpisode(){
        return qValuesPerEpisode;
    }
    /**
     * Get the policy name associated with the latest experiment.
     * @return  The name of the experiment policy.
     */
    public String getPolicy(){
        return policy;
    }
    /**
     * Get the epsilon value associated with the experiment data.
     * @return  The latest epsilon value associated with the experiment data.
     */
    public double getEpsilon(){
        return epsilon;
    }
    /**
     * Get the gamma value associated with the experiment data.
     * @return  The latest gamma value associated with the experiment data.
     */
    public double getGamma(){
        return gamma;
    }
    /**
     * Get the alpha value associated with the experiment data.
     * @return  The latest alpha value associated with the experiment data.
     */
    public double getAlpha(){
        return alpha;
    }
    /**
     * Get the coal state associated with the experiment data.
     * @return  The goal state associated with the experiment data.
     */
    public String getGoalState(){
        return goalState;
    }
    /**
     * Get the initial state associated with the experiment data.
     * @return  The initialState associated with the experiment data.
     */
    public String getInitialState(){
        return initialState;
    }
    /**
     * Get the temperature decrease per episode value associated with the experiment data.
     * @return  The latest temperature decrease per episode value associated with the experiment data.
     */
    public double getTemperatureRate(){
        return temperatureRate;
    }
    /**
     * Get the learning algorithm name associated with the experiment data.
     * @return  The latest learning algorithm name associated with the experiment data.
     */
    public String getAlgorithm(){
        return algorithm;
    }
    
    /**
     * Set the policy name associated with the experiment data.
     * @param policy    The policy name.
     */
    public void setPolicy(String policy){
        this.policy = policy;
    }
    /**
     * Set the epsilon value associated with the experiment data.
     * @param epsilon   The new value for epsilon.
     */
    public void setEpsilon(double epsilon){
        this.epsilon = epsilon;
    }
    /**
     * Set the gamma value associated with the experiment data.
     * @param gamma   The new value for gamma.
     */
    public void setGamma(double gamma){
        this.gamma = gamma;
    }
    /**
     * Set the alpha value associated with the experiment data.
     * @param alpha   The new value for alpha.
     */
    public void setAlpha(double alpha){
        this.alpha = alpha;
    }
    /**
     * Set the goal state associated with the experiment data.
     * @param gState   The new name for experiment goal state.
     */
    public void setGoalState(String gState){
        goalState = gState;
    }
    /**
     * Set the initial state name associated with the experiment data.
     * @param iState   The new name for experiment initial state.
     */
    public void setInitialState(String iState){
        initialState = iState;
    }
    /**
     * Set the temperature decrease per episode value associated with the experiment data.
     * @param temp   The new value for temperature decrease per episode.
     */
    public void setTemperatureRate(double temp){
        temperatureRate = temp;
    }
    /**
     * Set the learning algorithm name associated with the experiment data.
     * @param algorithm   The new algorithm name.
     */
    public void setAlgorithm(String algorithm){
        this.algorithm = algorithm;
    }
}
