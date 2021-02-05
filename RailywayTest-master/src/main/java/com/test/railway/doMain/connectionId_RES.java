package com.test.railway.doMain;

import java.util.List;

public class connectionId_RES {

    /**
     * connectionId_RES : mgfq_shngjPjxkijg4LmQw
     * availableTransports : [{"transport":"WebSockets","transferFormats":["Text","Binary"]},{"transport":"ServerSentEvents","transferFormats":["Text"]},{"transport":"LongPolling","transferFormats":["Text","Binary"]}]
     */

    private String connectionId;
    private List<AvailableTransportsBean> availableTransports;

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public List<AvailableTransportsBean> getAvailableTransports() {
        return availableTransports;
    }

    public void setAvailableTransports(List<AvailableTransportsBean> availableTransports) {
        this.availableTransports = availableTransports;
    }

    public static class AvailableTransportsBean {
        /**
         * transport : WebSockets
         * transferFormats : ["Text","Binary"]
         */

        private String transport;
        private List<String> transferFormats;

        public String getTransport() {
            return transport;
        }

        public void setTransport(String transport) {
            this.transport = transport;
        }

        public List<String> getTransferFormats() {
            return transferFormats;
        }

        public void setTransferFormats(List<String> transferFormats) {
            this.transferFormats = transferFormats;
        }
    }
}
