package com.gitile.fast.core.utils;

import java.io.File;

public class FilenameUtils {
	
    /**
     * The Unix separator character.
     */
    private static final char UNIX_SEPARATOR = '/';

    /**
     * The Windows separator character.
     */
    private static final char WINDOWS_SEPARATOR = '\\';
    
    /**
     * The system separator character.
     */
    private static final char SYSTEM_SEPARATOR = File.separatorChar;
    
	/**
	 * 构造方法
	 */
	private FilenameUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
     * Converts all separators to the Unix separator of forward slash.
     * 
     * @param path  the path to be changed, null ignored
     * @return the updated path
     */
    public static String separatorsToUnix(String path) {
        if (path == null || path.indexOf(WINDOWS_SEPARATOR) == -1) {
            return path;
        }
        return path.replace(WINDOWS_SEPARATOR, UNIX_SEPARATOR);
    }

    /**
     * Converts all separators to the Windows separator of backslash.
     * 
     * @param path  the path to be changed, null ignored
     * @return the updated path
     */
    public static String separatorsToWindows(String path) {
        if (path == null || path.indexOf(UNIX_SEPARATOR) == -1) {
            return path;
        }
        return path.replace(UNIX_SEPARATOR, WINDOWS_SEPARATOR);
    }
    
    /**
     * Determines if Windows file system is in use.
     * 
     * @return true if the system is Windows
     */
    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == WINDOWS_SEPARATOR;
    }

    /**
     * Converts all separators to the system separator.
     * 
     * @param path  the path to be changed, null ignored
     * @return the updated path
     */
    public static String separatorsToSystem(String path) {
        if (path == null) {
            return null;
        }
        if (isSystemWindows()) {
            return separatorsToWindows(path);
        } else {
            return separatorsToUnix(path);
        }
    }

}
