package com.yixun.library.tools;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.yixun.library.annotation.SaveField;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Zheng Yang on 2018/3/27 16:16
 */

public class Couple {
    private static final String TAG = Couple.class.getSimpleName();

    public static void readInstance(Object obj, Bundle saveInstance) {
        Class acls = obj.getClass();
        Field[] fields = acls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SaveField.class)) {
                String key = field.getName();
                Log.d(TAG, "key=" + key);
                Type type = field.getType();
                Object object = null;
                if (type == Integer.TYPE) {
                    object = saveInstance.getInt(key);
                } else if (type == int[].class) {
                    object = saveInstance.getIntArray(key);
                } else if (type == Boolean.TYPE) {
                    object = saveInstance.getBoolean(key, false);
                } else if (type == boolean[].class) {
                    object = saveInstance.getBooleanArray(key);
                } else if (type == String.class) {
                    object = saveInstance.getString(key);
                    Log.d(TAG, object.toString());
                } else if (type == String[].class) {
                    object = saveInstance.getStringArray(key);
                } else if (type == Long.TYPE) {
                    object = saveInstance.getLong(key);
                } else if (type == long[].class) {
                    object = saveInstance.getLongArray(key);
                } else if (type == Short.TYPE) {
                    object = saveInstance.getShort(key);
                } else if (type == short[].class) {
                    object = saveInstance.getShortArray(key);
                } else if (type == Byte.TYPE) {
                    object = saveInstance.getByte(key);
                } else if (type == byte[].class) {
                    object = saveInstance.getByteArray(key);
                } else if (type == Float.TYPE) {
                    object = saveInstance.getFloat(key);
                } else if (type == float[].class) {
                    object = saveInstance.getFloatArray(key);
                } else if (type == Double.TYPE) {
                    object = saveInstance.getDouble(key);
                } else if (type == double[].class) {
                    object = saveInstance.getDoubleArray(key);
                } else if (type == char.class) {
                    object = saveInstance.getChar(key);
                } else if (type.getClass().isAssignableFrom(CharSequence.class)) {
                    object = saveInstance.getCharSequenceArrayList(key);
                } else if (type.getClass().isAssignableFrom(CharSequence[].class)) {
                    object = saveInstance.getCharSequenceArray(key);
                } else if (type.getClass().isAssignableFrom(Parcelable.class)) {
                    object = saveInstance.getParcelable(key);
                } else if (type.getClass().isAssignableFrom(Parcelable[].class)) {
                    object = saveInstance.getParcelableArray(key);
                } else if (type.getClass().isAssignableFrom(Serializable.class)) {
                    object = saveInstance.getSerializable(key);
                } else if (type == ArrayList.class) {
                    Type genericType = field.getGenericType();
                    if (genericType == Integer.TYPE) {
                        object = saveInstance.getIntegerArrayList(key);
                    } else if (genericType == String.class) {
                        object = saveInstance.getStringArrayList(key);
                    } else if (genericType.getClass().isAssignableFrom(CharSequence.class)) {
                        object = saveInstance.getCharSequenceArrayList(key);
                    } else if (genericType.getClass().isAssignableFrom(Parcelable.class)) {
                        object = saveInstance.getParcelableArrayList(key);
                    }
                }
                try {
                    field.setAccessible(true);
                    field.set(obj, object);
                } catch (IllegalAccessException e) {
                    Log.d(TAG, "数据读取错误，请检查");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveInstance(Object obj, Bundle saveInstance) {
        Class acls = obj.getClass();
        Field[] fields = acls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SaveField.class)) {
                String key = field.getName();
                Log.d(TAG, "key=" + key);
                Type type = field.getType();
                field.setAccessible(true);
                Object object = null;
                try {
                    object = field.get(acls);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (type == Integer.TYPE) {
                    saveInstance.putInt(key, (int) object);
                } else if (type == int[].class) {
                    saveInstance.putIntArray(key, (int[]) object);
                } else if (type == Boolean.TYPE) {
                    saveInstance.putBoolean(key, (boolean) object);
                } else if (type == boolean[].class) {
                    saveInstance.putBooleanArray(key, (boolean[]) object);
                } else if (type == String.class) {
                    saveInstance.putString(key, (String) object);
                } else if (type == String[].class) {
                    saveInstance.putStringArray(key, (String[]) object);
                } else if (type == Long.TYPE) {
                    saveInstance.putLong(key, (long) object);
                } else if (type == long[].class) {
                    saveInstance.putLongArray(key, (long[]) object);
                } else if (type == Short.TYPE) {
                    saveInstance.putShort(key, (short) object);
                } else if (type == short[].class) {
                    saveInstance.putShortArray(key, (short[]) object);
                } else if (type == Byte.TYPE) {
                    saveInstance.putByte(key, (byte) object);
                } else if (type == byte[].class) {
                    saveInstance.putByteArray(key, (byte[]) object);
                } else if (type == Float.TYPE) {
                    saveInstance.putFloat(key, (float) object);
                } else if (type == float[].class) {
                    saveInstance.putFloatArray(key, (float[]) object);
                } else if (type == Double.TYPE) {
                    saveInstance.putDouble(key, (double) object);
                } else if (type == double[].class) {
                    saveInstance.putDoubleArray(key, (double[]) object);
                } else if (type == char.class) {
                    saveInstance.putChar(key, (char) object);
                } else if (type.getClass().isAssignableFrom(CharSequence.class)) {
                    saveInstance.putCharSequenceArrayList(key, (ArrayList<CharSequence>) object);
                } else if (type.getClass().isAssignableFrom(CharSequence[].class)) {
                    saveInstance.putCharSequenceArray(key, (CharSequence[]) object);
                } else if (type.getClass().isAssignableFrom(Parcelable.class)) {
                    saveInstance.putParcelable(key, (Parcelable) object);
                } else if (type.getClass().isAssignableFrom(Parcelable[].class)) {
                    saveInstance.putParcelableArray(key, (Parcelable[]) object);
                } else if (type.getClass().isAssignableFrom(Serializable.class)) {
                    saveInstance.putSerializable(key, (Serializable) object);
                } else if (type == ArrayList.class) {
                    Type genericType = field.getGenericType();
                    if (genericType == Integer.TYPE) {
                        saveInstance.putIntegerArrayList(key, (ArrayList<Integer>) object);
                    } else if (genericType == String.class) {
                        saveInstance.putStringArrayList(key, (ArrayList<String>) object);
                    } else if (genericType.getClass().isAssignableFrom(CharSequence.class)) {
                        saveInstance.putCharSequenceArrayList(key, (ArrayList<CharSequence>) object);
                    } else if (genericType.getClass().isAssignableFrom(Parcelable.class)) {
                        saveInstance.putParcelableArrayList(key, (ArrayList<? extends Parcelable>) object);
                    }
                }
            }
        }
    }
}
