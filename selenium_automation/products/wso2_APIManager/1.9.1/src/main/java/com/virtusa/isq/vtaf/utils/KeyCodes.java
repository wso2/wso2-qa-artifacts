/*
 * Copyright 2004 ThoughtWorks, Inc. Licensed under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.virtusa.isq.vtaf.utils;

/*
 * 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class KeyCodes. Holds the key codes which will be used across many
 * command in the runtime. Key codes are saved within a hash map and the key
 * represents the actual key combination of the keyboard. The hash map will be
 * initialized at the constructor of the key codes.
 */
public class KeyCodes {

    /** The key codes hash map. */
    private Map<String, int[]> keyCodes;

    /**
     * Instantiates a new key codes.
     */
    public KeyCodes() {
        init();
    }

    /**
     * Inits the key codes which will be used across many command in the
     * runtime. Key codes are saved within a hash map and the key represents the
     * actual key combination of the keyboard. The hash map will be initialized
     * at the constructor of the key codes.
     * 
     * For key code for simulating key 'a' pass the String "a" For key code for
     * simulating key 'b' pass the String "a" For key code for simulating key
     * 'c' pass the String "a" For key code for simulating key 'D' pass the
     * String "D" For key code for simulating key 'E' pass the String "E" For
     * key code for simulating key 'F' pass the String "F" For key code for
     * simulating key 'alt+F4' pass the String "alt+F4 For key code for
     * simulating key 'shift+\t' pass the String "shift+\t" For key code for
     * simulating key 'ctrl+o' pass the String "ctrl+o"
     * 
     */
    private void init() {
        keyCodes = new HashMap<String, int[]>();
        // key code for key event "a"
        keyCodes.put("a", new int[] {KeyEvent.VK_A});
        // key code for key event "b"
        keyCodes.put("b", new int[] {KeyEvent.VK_B});
        // key code for key event "c"
        keyCodes.put("c", new int[] {KeyEvent.VK_C});
        // key code for key event "d"
        keyCodes.put("d", new int[] {KeyEvent.VK_D});
        // key code for key event "e"
        keyCodes.put("e", new int[] {KeyEvent.VK_E});
        // key code for key event "f"
        keyCodes.put("f", new int[] {KeyEvent.VK_F});
        // key code for key event "g"
        keyCodes.put("g", new int[] {KeyEvent.VK_G});
        // key code for key event "h"
        keyCodes.put("h", new int[] {KeyEvent.VK_H});
        // key code for key event "i"
        keyCodes.put("i", new int[] {KeyEvent.VK_I});
        // key code for key event "j"
        keyCodes.put("j", new int[] {KeyEvent.VK_J});
        // key code for key event "k"
        keyCodes.put("k", new int[] {KeyEvent.VK_K});
        // key code for key event "l"
        keyCodes.put("l", new int[] {KeyEvent.VK_L});
        // key code for key event "m"
        keyCodes.put("m", new int[] {KeyEvent.VK_M});
        // key code for key event "n"
        keyCodes.put("n", new int[] {KeyEvent.VK_N});
        // key code for key event "o"
        keyCodes.put("o", new int[] {KeyEvent.VK_O});
        // key code for key event "p"
        keyCodes.put("p", new int[] {KeyEvent.VK_P});
        // key code for key event "q"
        keyCodes.put("q", new int[] {KeyEvent.VK_Q});
        // key code for key event "r"
        keyCodes.put("r", new int[] {KeyEvent.VK_R});
        keyCodes.put("s", new int[] {KeyEvent.VK_S});
        keyCodes.put("t", new int[] {KeyEvent.VK_T});
        keyCodes.put("u", new int[] {KeyEvent.VK_U});
        keyCodes.put("v", new int[] {KeyEvent.VK_V});
        keyCodes.put("w", new int[] {KeyEvent.VK_W});
        keyCodes.put("x", new int[] {KeyEvent.VK_X});
        keyCodes.put("y", new int[] {KeyEvent.VK_Y});
        keyCodes.put("z", new int[] {KeyEvent.VK_Z});
        keyCodes.put("A", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_A});
        keyCodes.put("B", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_B});
        keyCodes.put("C", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_C});
        keyCodes.put("D", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_D});
        keyCodes.put("E", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_E});
        keyCodes.put("F", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_F});
        keyCodes.put("G", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_G});
        keyCodes.put("H", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_H});
        keyCodes.put("I", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_I});
        keyCodes.put("J", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_J});
        keyCodes.put("K", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_K});
        keyCodes.put("L", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_L});
        keyCodes.put("M", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_M});
        keyCodes.put("N", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_N});
        keyCodes.put("O", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_O});
        keyCodes.put("P", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_P});
        keyCodes.put("Q", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_Q});
        keyCodes.put("R", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_R});
        keyCodes.put("S", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_S});
        keyCodes.put("T", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_T});
        keyCodes.put("U", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_U});
        keyCodes.put("V", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_V});
        keyCodes.put("W", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_W});
        keyCodes.put("X", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_X});
        keyCodes.put("Y", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_Y});
        keyCodes.put("Z", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_Z});
        keyCodes.put("`", new int[] {KeyEvent.VK_BACK_QUOTE});
        keyCodes.put("0", new int[] {KeyEvent.VK_0});
        keyCodes.put("1", new int[] {KeyEvent.VK_1});
        keyCodes.put("2", new int[] {KeyEvent.VK_2});
        keyCodes.put("3", new int[] {KeyEvent.VK_3});
        keyCodes.put("4", new int[] {KeyEvent.VK_4});
        keyCodes.put("5", new int[] {KeyEvent.VK_5});
        keyCodes.put("6", new int[] {KeyEvent.VK_6});
        keyCodes.put("7", new int[] {KeyEvent.VK_7});
        keyCodes.put("8", new int[] {KeyEvent.VK_8});
        keyCodes.put("9", new int[] {KeyEvent.VK_9});
        keyCodes.put("-", new int[] {KeyEvent.VK_MINUS});
        keyCodes.put("=", new int[] {KeyEvent.VK_EQUALS});
        keyCodes.put("~", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE});
        keyCodes.put("!", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_1});
        keyCodes.put("@", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_2});
        keyCodes.put("#", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_3});
        keyCodes.put("$", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_4});
        keyCodes.put("%", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_5});
        keyCodes.put("^", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_6});
        keyCodes.put("&", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_7});
        keyCodes.put("*", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_8});
        keyCodes.put("(", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_9});
        keyCodes.put(")", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_0});
        keyCodes.put("_", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS});
        keyCodes.put("+", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_EQUALS});
        keyCodes.put("\t", new int[] {KeyEvent.VK_TAB});
        keyCodes.put("\n", new int[] {KeyEvent.VK_ENTER});
        keyCodes.put("[", new int[] {KeyEvent.VK_OPEN_BRACKET});
        keyCodes.put("]", new int[] {KeyEvent.VK_CLOSE_BRACKET});
        keyCodes.put("\\", new int[] {KeyEvent.VK_BACK_SLASH});
        keyCodes.put("{", new int[] {KeyEvent.VK_SHIFT,
                KeyEvent.VK_OPEN_BRACKET});
        keyCodes.put("}", new int[] {KeyEvent.VK_SHIFT,
                KeyEvent.VK_CLOSE_BRACKET});
        keyCodes.put("|", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH});
        keyCodes.put(";", new int[] {KeyEvent.VK_SEMICOLON});
        keyCodes.put(":", new int[] {KeyEvent.VK_COLON});
        keyCodes.put("'", new int[] {KeyEvent.VK_QUOTE});
        keyCodes.put("\"", new int[] {KeyEvent.VK_QUOTEDBL});
        keyCodes.put(",", new int[] {KeyEvent.VK_COMMA});
        keyCodes.put("<", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA});
        keyCodes.put(".", new int[] {KeyEvent.VK_PERIOD});
        keyCodes.put(">", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD});
        keyCodes.put("/", new int[] {KeyEvent.VK_SLASH});
        keyCodes.put("?", new int[] {KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH});
        keyCodes.put(" ", new int[] {KeyEvent.VK_SPACE});
        keyCodes.put("alt", new int[] {KeyEvent.VK_ALT});
        keyCodes.put("ctrl", new int[] {KeyEvent.VK_CONTROL});
        keyCodes.put("esc", new int[] {KeyEvent.VK_ESCAPE});
        keyCodes.put("down", new int[] {KeyEvent.VK_DOWN});
        keyCodes.put("up", new int[] {KeyEvent.VK_UP});
        keyCodes.put("left", new int[] {KeyEvent.VK_LEFT});
        keyCodes.put("right", new int[] {KeyEvent.VK_RIGHT});
        keyCodes.put("F1", new int[] {KeyEvent.VK_F1});
        keyCodes.put("F2", new int[] {KeyEvent.VK_F2});
        keyCodes.put("F3", new int[] {KeyEvent.VK_F3});
        keyCodes.put("F4", new int[] {KeyEvent.VK_F4});
        keyCodes.put("F5", new int[] {KeyEvent.VK_F5});
        keyCodes.put("F6", new int[] {KeyEvent.VK_F6});
        keyCodes.put("F7", new int[] {KeyEvent.VK_F7});
        keyCodes.put("F8", new int[] {KeyEvent.VK_F8});
        keyCodes.put("F9", new int[] {KeyEvent.VK_F9});
        keyCodes.put("F10", new int[] {KeyEvent.VK_F10});
        keyCodes.put("F11", new int[] {KeyEvent.VK_F11});
        keyCodes.put("F12", new int[] {KeyEvent.VK_F12});
        keyCodes.put("insert", new int[] {KeyEvent.VK_INSERT});
        keyCodes.put("home", new int[] {KeyEvent.VK_HOME});
        keyCodes.put("pageup", new int[] {KeyEvent.VK_PAGE_UP});
        keyCodes.put("backspace", new int[] {KeyEvent.VK_BACK_SPACE});
        keyCodes.put("delete", new int[] {KeyEvent.VK_DELETE});
        keyCodes.put("end", new int[] {KeyEvent.VK_END});
        keyCodes.put("pagedown", new int[] {KeyEvent.VK_PAGE_DOWN});

    }

    /**
     * Gets the key codes for the given character. Returns the key code array
     * for the given key combination.
     * 
     * @param character
     *            the character
     * @return the key codes
     */
    public final int[] getKeyCodes(final String character) {
        return keyCodes.get(character);
    }

}
