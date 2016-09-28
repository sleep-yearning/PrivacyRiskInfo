package com.bp.Trophies;

/**
 * Created by Ich on 17.09.2016.
 */
abstract public class TrophyObject {

    String name; //the trophy's name
    int scoreNeeded; //the value that has to be reached for the trophy to be unlocked
    int scoreCurrently; //the current value

    String toastDescription; //the toast displayed when you click the trophy (should describe it)
    boolean visibleScore; //if the progress is displayed (eg. 4/10) or not (???)
    boolean unlocked; //whether the trophy is already unlocked
    int icon; //the trophy's icon resource path


    public TrophyObject(String name, int scoreNeeded, String toastDescription, boolean visibleScore, int icon) {
        this.name = name;
        this.scoreNeeded = scoreNeeded;
        this.toastDescription = toastDescription;
        this.scoreCurrently = scoreCurrently;
        this.visibleScore = visibleScore;
        this.icon = icon;
    }

    /**check whether the trophy's conditions for unlocking are currently met and unlocks it
     * @author Tim
     * @return true ->trophy is unlocked, false -> trophy is locked
     */
    abstract public boolean checkScore();


    /**fetch the current score of the trophy from ObserverSingleton and update it
     * @author Tim
     */
    abstract public void updateScore();


    public String getName() {
        return name;
    }
    public int getScoreNeeded() {
        return scoreNeeded;
    }
    public int getScoreCurrently() {
        return scoreCurrently;
    }
    public int getIcon() {
        return icon;
    }
    public boolean isVisibleScore() {
        return visibleScore;
    }
    public boolean isUnlocked() {
        return unlocked;
    }
    public String getToastDescription() {
        return toastDescription;
    }

}
