package main.ma.maxim;

interface ViewInterface {

    public void setPresenter(Presenter presenter);

    public void setState(State newState);

    public void updateView();
}
