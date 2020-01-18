package SQL;

import javax.transaction.xa.Xid;

public class XADemo {
//    public static MysqlXADataSource GetDataSource(String connString, String user, String passwd) {
//        return null;
//    }
}

class MyXid implements Xid {
    public int formatId;
    public byte gtrid[];
    public byte bqual[];

    public MyXid() {

    }

    public MyXid(int formatId, byte[] gtrid, byte[] bqual) {
        this.formatId = formatId;
        this.gtrid = gtrid;
        this.bqual = bqual;
    }

    @Override
    public int getFormatId() {
        return formatId;
    }

    @Override
    public byte[] getGlobalTransactionId() {
        return gtrid;
    }

    @Override
    public byte[] getBranchQualifier() {
        return bqual;
    }
}
