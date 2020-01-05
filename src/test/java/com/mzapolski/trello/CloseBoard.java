package com.mzapolski.trello;

        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        //import trello_tests.model.BoardData;

public class CloseBoard extends TestBase {

    @BeforeMethod
    public void isBoardExist() {
        if (app.getBoardHelper().getPersonalBoardsCount() == 0) {
            BoardData board = new BoardData().withBoardTitle("a1");
            app.getBoardHelper().createBoardFromCreateBoardButton(board, "no", 0);
        }
    }

    @Test
    public void closeFirstPersonalBoardTest() {
        int before = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().closeFirstPersonalBoard();
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);
    }


}