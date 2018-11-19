package edu.ncsu.csc216.wolf_results.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ncsu.csc216.wolf_results.manager.WolfResultsManager;

/**
 * Wolf Results GUI.
 * 
 * @author INSERT PARTNER 1 HERE
 * @author INSERT PARTNER 2 HERE
 */
public class WolfResultsGUI extends JFrame implements ActionListener, Observer {

    /** ID number used for object serialization. */
    private static final long serialVersionUID = 1L;
    /** Title for top of GUI. */
    private static final String APP_TITLE = "Wolf Results";
    /** Text for the File Menu. */
    private static final String FILE_MENU_TITLE = "File";
    /** Text for the New Issue XML menu item. */
    private static final String NEW_FILE_TITLE = "New";
    /** Text for the Load Issue XML menu item. */
    private static final String LOAD_FILE_TITLE = "Load";
    /** Text for the Save menu item. */
    private static final String SAVE_FILE_TITLE = "Save";
    /** Text for the Quit menu item. */
    private static final String QUIT_TITLE = "Quit";
    /** Menu bar for the GUI that contains Menus. */
    private JMenuBar menuBar;
    /** Menu for the GUI. */
    private JMenu menu;
    /** Menu item for creating a new list of Races. */
    private JMenuItem itemNewFile;
    /** Menu item for loading a file. */
    private JMenuItem itemLoadFile;
    /** Menu item for saving the list to a file. */
    private JMenuItem itemSaveFile;
    /** Menu item for quitting the program. */
    private JMenuItem itemQuit;

    /**
     * Constructs the GUI.
     */
    public WolfResultsGUI() {
        super();

        // Observe Manager
        WolfResultsManager.getInstance().addObserver(this);

        // Set up general GUI info
        setSize(1500, 500);
        setLocation(50, 50);
        setTitle(APP_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUpMenuBar();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                doExit();
            }

        });

        initializeGUI();

        // Set the GUI visible
        setVisible(true);
    }

    /**
     * Initializes GUI
     */
    private void initializeGUI() {
        // TODO initialize your GUI
    	// We encourage creating inner classes for the major components of the GUI
    }

    /**
     * Makes the GUI Menu bar that contains options for loading a file
     * containing issues or for quitting the application.
     */
    private void setUpMenuBar() {
        // Construct Menu items
        menuBar = new JMenuBar();
        menu = new JMenu(FILE_MENU_TITLE);
        itemNewFile = new JMenuItem(NEW_FILE_TITLE);
        itemLoadFile = new JMenuItem(LOAD_FILE_TITLE);
        itemSaveFile = new JMenuItem(SAVE_FILE_TITLE);
        itemQuit = new JMenuItem(QUIT_TITLE);
        itemNewFile.addActionListener(this);
        itemLoadFile.addActionListener(this);
        itemSaveFile.addActionListener(this);
        itemQuit.addActionListener(this);

        // Start with save button disabled
        itemSaveFile.setEnabled(false);

        // Build Menu and add to GUI
        menu.add(itemNewFile);
        menu.add(itemLoadFile);
        menu.add(itemSaveFile);
        menu.add(itemQuit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    /**
     * Exits the GUI
     */
    private void doExit() {
        if (WolfResultsManager.getInstance().isChanged()) {
            doSaveFile();
        }

        if (!WolfResultsManager.getInstance().isChanged()) {
            System.exit(NORMAL);
        } else { // Did NOT save when prompted to save
            JOptionPane.showMessageDialog(this,
                    "Race Results changes have not been saved. "
                            + "Your changes will not be saved.",
                    "Saving Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Saves GUI to file
     */
    private void doSaveFile() {
        try {
            WolfResultsManager instance = WolfResultsManager.getInstance();
            JFileChooser chooser = new JFileChooser("./");
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Race Results files (md)", "md");
            chooser.setFileFilter(filter);
            chooser.setMultiSelectionEnabled(false);
            if (instance.getFilename() != null) {
                chooser.setSelectedFile(new File(instance.getFilename()));
            }
            int returnVal = chooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (chooser.getSelectedFile().getName().trim().equals("")
                        || !chooser.getSelectedFile().getName()
                                .endsWith(".md")) {
                    throw new IllegalArgumentException();
                }
                instance.setFilename(filename);
                instance.saveFile(filename);
            }
            itemLoadFile.setEnabled(true);
            itemNewFile.setEnabled(true);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "File not saved.",
                    "Saving Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Loads race results from file
     */
    private void doLoadFile() {
        try {
            WolfResultsManager instance = WolfResultsManager.getInstance();
            JFileChooser chooser = new JFileChooser("./");
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Race Results files (md)", "md");
            chooser.setFileFilter(filter);
            chooser.setMultiSelectionEnabled(false);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                instance.loadFile(chooser.getSelectedFile().getAbsolutePath());
            }
            itemLoadFile.setEnabled(false);
            itemNewFile.setEnabled(false);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error opening file.",
                    "Opening Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WolfResultsManager) {
            itemSaveFile.setEnabled(true);
            // TODO Call methods to update the contents of the GUI
            repaint();
            validate();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WolfResultsManager instance = WolfResultsManager.getInstance();

        if (e.getSource() == itemNewFile) {
            doSaveFile();
            instance.newList();
        } else if (e.getSource() == itemLoadFile) {
            doLoadFile();
        } else if (e.getSource() == itemSaveFile) {
            doSaveFile();
        } else if (e.getSource() == itemQuit) {
            doExit();
        }
    }

    /**
     * Starts the application
     * 
     * @param args command line args
     */
    public static void main(String[] args) {
        new WolfResultsGUI();
    }

}
