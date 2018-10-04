package com.alomardev.vcardplus.view;

import com.alomardev.vcardplus.utils.UIUtils;
import ezvcard.VCard;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTextField findTf, replaceTf;
    private JComboBox propertiesDdl;
    private JButton findBtn, replaceBtn, replaceAllBtn, nextBtn, prevBtn, clearBtn;
    private JCheckBox regexCb, matchCaseCb;
    private JLabel resultLbl;

    private JList<VCard> allList, matchList;

    public void setup() {
        setTitle("vCard+");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        findTf = new JTextField();

        replaceTf = new JTextField();

        propertiesDdl = new JComboBox(new String[] {"One", "Two", "Three"}) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, super.getPreferredSize().height);
            }
        };
        ((JLabel) propertiesDdl.getRenderer()).setHorizontalAlignment(JLabel.CENTER);

        findBtn = new JButton("Find") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, super.getPreferredSize().height);
            }
        };

        replaceBtn = new JButton("Replace");

        replaceAllBtn = new JButton("Replace All");

        nextBtn = new JButton(">>");

        prevBtn = new JButton("<<");

        clearBtn = new JButton("Clear");

        regexCb = new JCheckBox("Regex");

        matchCaseCb = new JCheckBox("Match Case");

        resultLbl = new JLabel("");

        allList = new JList<>();
        allList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        matchList = new JList<>();
        matchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel topPanel = new JPanel(), centerPanel = new JPanel();

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;

        // Top panel
        topPanel.setLayout(new GridBagLayout());

        UIUtils.gbc(c, 0, 0, 1, 1, 1, 0, -1, true, true, 2, 2, 2, 0);
        topPanel.add(findTf, c);

        UIUtils.gbc(c, 1, 0, 2, 1, 0, 0, -1, true, false, 0, 2, 2, 0);
        topPanel.add(propertiesDdl, c);

        UIUtils.gbc(c, 3, 0, 1, 1, 0, 0, -1, true, false, 0, 2, 2, 0);
        topPanel.add(findBtn, c);

        UIUtils.gbc(c, 0, 1, 1, 1, 1, 0, -1, true, true, 2, 2, 2, 0);
        topPanel.add(replaceTf, c);

        UIUtils.gbc(c, 1, 1, 2, 1, 0, 0, -1, true, false, 0, 2, 2, 0);
        topPanel.add(replaceBtn, c);

        UIUtils.gbc(c, 3, 1, 1, 1, 0, 0, -1, true, false, 0, 2, 2, 0);
        topPanel.add(replaceAllBtn, c);

        JPanel checkboxContainer = new JPanel();
        checkboxContainer.setLayout(new BoxLayout(checkboxContainer, BoxLayout.X_AXIS));
        checkboxContainer.add(regexCb);
        checkboxContainer.add(matchCaseCb);
        checkboxContainer.add(Box.createHorizontalGlue());
        checkboxContainer.add(resultLbl);
        UIUtils.gbc(c, 0, 2, 1, 1, 1, 0, -1, true, true, 2, 2, 2, 0);
        topPanel.add(checkboxContainer, c);

        UIUtils.gbc(c, 1, 2, 1, 1, 0, 0, -1, true, false, 0, 2, 1, 0);
        topPanel.add(prevBtn, c);

        UIUtils.gbc(c, 2, 2, 1, 1, 0, 0, -1, true, false, 1, 2, 2, 0);
        topPanel.add(nextBtn, c);

        UIUtils.gbc(c, 3, 2, 1, 1, 0, 0, -1, true, false, 0, 2, 2, 0);
        topPanel.add(clearBtn, c);

        UIUtils.gbc(c, 0, 3, 10, 1, 1, 0, -1, true, false, 0, 2, 0, 2);
        topPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Center panel
        centerPanel.setLayout(new GridBagLayout());

        JPanel detailsPanel = new JPanel(new SpringLayout());

        JLabel allListLbl = new JLabel("All"), matchListLbl = new JLabel("Result"), detailsLbl = new JLabel("Details");
        JScrollPane allListSp = new JScrollPane(allList);
        allListSp.setPreferredSize(new Dimension(100, 0));
        JScrollPane matchListSp = new JScrollPane(matchList);
        matchListSp.setPreferredSize(new Dimension(100, 0));
        JScrollPane detailsSp = new JScrollPane(detailsPanel);
        detailsSp.setPreferredSize(new Dimension(100, 0));

        UIUtils.gbc(c, 0, 0, 1, 1, 1, 0, -1, true, false, 3, 0, 1, 1);
        centerPanel.add(allListLbl, c);

        UIUtils.gbc(c, 1, 0, 1, 1, 1, 0, -1, true, false, 2, 0, 1, 1);
        centerPanel.add(matchListLbl, c);

        UIUtils.gbc(c, 2, 0, 1, 1, 2, 0, -1, true, false, 2, 0, 2, 1);
        centerPanel.add(detailsLbl, c);

        UIUtils.gbc(c, 0, 1, 1, 1, 1, 1, -1, true, true, 2, 0, 1, 2);
        centerPanel.add(allListSp, c);

        UIUtils.gbc(c, 1, 1, 1, 1, 1, 1, -1, true, true, 1, 0, 1, 2);
        centerPanel.add(matchListSp, c);

        UIUtils.gbc(c, 2, 1, 1, 1, 2, 1, -1, true, true, 1, 0, 2, 2);
        detailsPanel.add(new JLabel("Test"));
        centerPanel.add(detailsSp, c);

        pack();
        setMinimumSize(getPreferredSize());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(560, 480);
    }
}
