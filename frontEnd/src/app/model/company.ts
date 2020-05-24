export interface Company {
    id:string;
    companyName:string;
    stockCode:string;
    turnOver:string;
    ceo:string;
    //ipoDate:string;
    exchangeName:string;
    briefIntro:string;
    sectorsBySectorsId:{
        id:string;
        sectorName:string;
    }
}
