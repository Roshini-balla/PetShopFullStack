export enum TransactionStatus {
  Success = 'Success',
  Failed = 'Failed'
}

export interface Transactions {
  transactionId: number;
  customer: any;  // Assuming customer object has been defined elsewhere
  pet: any;       // Assuming pet object has been defined elsewhere
  transactionDate: Date;
  amount: number;
  transactionStatus: 'Success';
}
