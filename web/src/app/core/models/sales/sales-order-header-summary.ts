export interface SalesOrderHeaderSummary {
  salesOrderId?: number;
  orderDate?: any;
  status?: number;
  statusDescription?: string;
  accountNumber?: string;
  address?: string;
  subTotal?: number;
  taxAmt?: number;
  freight?: number;
  totalDue?: number;
  empployeeFullName?: string;
}
