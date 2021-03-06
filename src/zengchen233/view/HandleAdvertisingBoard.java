package zengchen233.view;

import zengchen233.cn.Advertisement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class: HandleAdvertisingBoard
 * @author: Zc
 * @Date: 2021/03/21 11:05
 * @Description:
 */
public class HandleAdvertisingBoard implements ActionListener {
    AdvertisingBoardView view;                              //广告牌
    Advertisement advertisement;                            //广告牌上要显示的一个广告

    public void setView(AdvertisingBoardView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.next) {
            if (view.advertisingBoard != null) {
                advertisement = view.advertisingBoard.nextAdvertisement();
                handleAdvertisement(advertisement);
            }
            else {
                JOptionPane.showMessageDialog(view,"没有广告","消息对话框",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == view.previous) {
            if (view.advertisingBoard != null) {
                advertisement = view.advertisingBoard.previousAdvertisement();
                handleAdvertisement(advertisement);
            }
            else {
                JOptionPane.showMessageDialog(null,"没有广告","消息对话框",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void handleAdvertisement(Advertisement advertisement) {
        if (advertisement == null) {
            JOptionPane.showMessageDialog(view,"没有广告","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        else {
            view.showID.setText(advertisement.getID());
            view.showNumber.setText(advertisement.getSerialNumber());
            view.showContent.setText(advertisement.getContent());
            view.showImage.setImage(advertisement.getImage());
            view.showImage.repaint();
        }
    }
}
