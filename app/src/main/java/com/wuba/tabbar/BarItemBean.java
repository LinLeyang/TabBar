package com.wuba.tabbar;

/**
 * Created by linyueyang on 10/9/16.
 */
public class BarItemBean {

    private int image;
    private int image_selected;
    private String text;
    private int text_color;
    private int text_color_selected;

    public BarItemBean(int image, int image_selected, String text, int text_color, int text_color_selected) {
        this.image = image;
        this.image_selected = image_selected;
        this.text = text;
        this.text_color = text_color;
        this.text_color_selected = text_color_selected;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage_selected() {
        return image_selected;
    }

    public void setImage_selected(int image_selected) {
        this.image_selected = image_selected;
    }

    public int getText_color() {
        return text_color;
    }

    public void setText_color(int text_color) {
        this.text_color = text_color;
    }

    public int getText_color_selected() {
        return text_color_selected;
    }

    public void setText_color_selected(int text_color_selected) {
        this.text_color_selected = text_color_selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
