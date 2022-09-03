package fr.harrysto.vb.objects.gui;

import fr.harrysto.vb.main;
import fr.harrysto.vb.objects.gui.button.ButtonMessage;
import fr.harrysto.vb.objects.gui.container.CustomTextField;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.network.message.MessageSend;
import javafx.scene.paint.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import scala.reflect.macros.compiler.DefaultMacroCompiler;

import java.io.IOException;

public class MessageGUI extends GuiScreen {

    int guiWidth = 175;
    int guiHeight = 235;

    GuiButtonImage button1;
    GuiButtonImage button2;

    private CustomTextField text;
    private CustomTextField destinataireprenom;
    private CustomTextField destinatairenom;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        int GuiX = (width - guiWidth) / 30;
        int GuiY = (height - guiHeight) / 2;
        GL11.glColor4f(1, 1, 1, 1);
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/guimessage.png"));
        drawTexturedModalRect(GuiX, GuiY, 0, 0, guiWidth, guiHeight);
        this.text.drawTextBox();
        this.text.setEnableBackgroundDrawing(false);
        this.text.setTextColor(28);
        this.destinataireprenom.drawTextBox();
        this.destinataireprenom.setEnableBackgroundDrawing(false);
        this.destinataireprenom.setTextColor(28);
        this.destinatairenom.drawTextBox();
        this.destinatairenom.setTextColor(28);
        this.destinatairenom.setEnableBackgroundDrawing(false);
       super.drawScreen(mouseX, mouseY, partialTicks);

    }

    @Override
    public void initGui() {
        int GuiX = (width - guiWidth) / 30;
        int GuiY = (height - guiHeight) / 2;
        buttonList.clear();
        this.text = new CustomTextField(1 ,this.fontRenderer, GuiX + 20, GuiY + 55, 137, 20);
        this.destinataireprenom = new CustomTextField(2, this.fontRenderer, GuiX + 20, GuiY + 100, 137, 20);
        this.destinatairenom = new CustomTextField(3, this.fontRenderer, GuiX + 20, GuiY + 140, 137, 20);
        text.setMaxStringLength(50);
        text.setText("Ecrivez votre message.");
        this.text.setFocused(false);
        destinataireprenom.setMaxStringLength(30);
        destinataireprenom.setText("Prénom Du Destinataire");
        this.destinataireprenom.setFocused(false);
        destinatairenom.setMaxStringLength(30);
        destinatairenom.setText("Nom Du Destinataire");
        this.destinatairenom.setFocused(false);
        buttonList.add(button1 = new ButtonMessage(0, GuiX + 75, GuiY + 213, 37, 10, 75 , 239, 0, 0));
        super.initGui();

    }



    @Override
    public void actionPerformed(GuiButton button) throws IOException {
        if(button.id == 0){
            System.out.println(this.text.getText());
            System.out.println(this.destinataireprenom.getText());
            main.sendMessage.sendToServer(new MessageSend(this.destinataireprenom.getText(), this.destinatairenom.getText(), this.text.getText(), Minecraft.getMinecraft().player.getDisplayNameString()));

        }
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        this.text.textboxKeyTyped(typedChar, keyCode);
        this.destinataireprenom.textboxKeyTyped(typedChar, keyCode);
        this.destinatairenom.textboxKeyTyped(typedChar, keyCode);
    }

    public void updateScreen(){
        super.updateScreen();
        this.text.updateCursorCounter();
        this.destinataireprenom.updateCursorCounter();
        this.destinatairenom.updateCursorCounter();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.text.mouseClicked(mouseX, mouseY, mouseButton);
        this.destinataireprenom.mouseClicked(mouseX, mouseY, mouseButton);
        this.destinatairenom.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame() {
        super.doesGuiPauseGame();
        return false;
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }
}
