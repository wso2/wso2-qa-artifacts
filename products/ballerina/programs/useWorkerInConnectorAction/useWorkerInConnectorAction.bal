
import ballerina.lang.messages;
import ballerina.lang.system;
import ballerina.lang.strings;


connector Calculator(string txt){

    action add1(Calculator jcl, int a, int b) (message) {

      worker worker1(message m){
        int response=100;
        system:println("In worker 1" );
        messages:setStringPayload(m,strings:valueOf(response));
        reply m;
      }

        message m={};
        message response={};

        m -> worker1;
        system:println("respose: Calculator" );

        response <- worker1;
        return response;
    }

    action substract1(Calculator jcl, int a, int b) (int) {
        int response=a-b;
        return response;
    }
}

connector Calculator2(string txt){

    action add1(Calculator2 jcl, int a, int b) (message) {

      worker worker2(message m){
        int response=1000;
        system:println("In worker 2" );
        messages:setStringPayload(m,strings:valueOf(response));
        reply m;
      }

        message m={};
        message response={};

        m -> worker2;
        system:println("response: Calculator2" );

        response <- worker2;
        return response;
    }


}



function main(string[] args){

 message m;
 if(false){
   Calculator cal = create Calculator("text");
    m = Calculator.add1(cal, 1,2);

 }else{
   Calculator2 cal = create Calculator2("text");
    m = Calculator2.add1(cal, 1,2);

 }


   system:println("respose: " + messages:getStringPayload(m));

}
