package main.ma.maxim;

interface IView {
    void setPresenter(IPresenter presenter);
    void showLogin();
    void showMessage(String Title,String text);
}
