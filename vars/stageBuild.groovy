def proc1() {
    echo "proc1"
}

def proc2() {
    echo "proc2"
}

def call() {
    stage('Stage Build') {
        proc1()
        proc2()
    }
}