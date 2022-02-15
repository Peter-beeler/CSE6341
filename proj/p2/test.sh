TESTCASES=$(find ./ -type f -name 't*')

for i in $TESTCASES; do
    echo "===> Running testcase $i"
    ./plan "$i"
done