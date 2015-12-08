package com.io;

import com.communication.AlpaMessage;
import com.communication.TextAlpaMessage;

import java.util.Scanner;

/**
 * Created by softinite on 04/02/14.
 */
public class AlpaMessageReader {
    public AlpaMessage readMessage() {
        Scanner console = new Scanner(System.in);
        return new TextAlpaMessage(console.nextLine());
    }
}
