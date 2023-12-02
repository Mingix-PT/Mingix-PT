package hust.soict.hedspi.aims.screen.manager;

public class TurnOff {
    public static void TurnOffAddMediaScreen(AddItemToStoreScreen AddMediaScreen, StoreScreenManager storeScreenManager) {
        AddMediaScreen.dispose();
        storeScreenManager.reRenderStoreScreen();
    }
}
