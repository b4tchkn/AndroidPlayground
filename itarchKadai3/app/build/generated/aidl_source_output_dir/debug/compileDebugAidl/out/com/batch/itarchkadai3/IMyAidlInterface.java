/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.batch.itarchkadai3;
// Declare any non-default types here with import statements

public interface IMyAidlInterface extends android.os.IInterface
{
  /** Default implementation for IMyAidlInterface. */
  public static class Default implements com.batch.itarchkadai3.IMyAidlInterface
  {
    /**
         * Demonstrates some basic types that you can use as parameters
         * and return values in AIDL.
         *///    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
    //            double aDouble, String aString);

    @Override public int getResult(int val1, int val2) throws android.os.RemoteException
    {
      return 0;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.batch.itarchkadai3.IMyAidlInterface
  {
    private static final java.lang.String DESCRIPTOR = "com.batch.itarchkadai3.IMyAidlInterface";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.batch.itarchkadai3.IMyAidlInterface interface,
     * generating a proxy if needed.
     */
    public static com.batch.itarchkadai3.IMyAidlInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.batch.itarchkadai3.IMyAidlInterface))) {
        return ((com.batch.itarchkadai3.IMyAidlInterface)iin);
      }
      return new com.batch.itarchkadai3.IMyAidlInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getResult:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _result = this.getResult(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.batch.itarchkadai3.IMyAidlInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * Demonstrates some basic types that you can use as parameters
           * and return values in AIDL.
           *///    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
      //            double aDouble, String aString);

      @Override public int getResult(int val1, int val2) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(val1);
          _data.writeInt(val2);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getResult, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getResult(val1, val2);
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.batch.itarchkadai3.IMyAidlInterface sDefaultImpl;
    }
    static final int TRANSACTION_getResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.batch.itarchkadai3.IMyAidlInterface impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.batch.itarchkadai3.IMyAidlInterface getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * Demonstrates some basic types that you can use as parameters
       * and return values in AIDL.
       *///    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
  //            double aDouble, String aString);

  public int getResult(int val1, int val2) throws android.os.RemoteException;
}
