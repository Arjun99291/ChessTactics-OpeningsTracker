#!/bin/bash
# Simple Interest Calculation
# Prompt user for input
echo "Enter the principal amount (in USD): "
read principal
echo "Enter the rate of interest (as a percentage): "
read rate
echo "Enter the time period (in years): "
read time

# Calculate simple interest
simple_interest=$(echo "$principal * $rate * $time / 100" | bc)

# Display the result
echo "The simple interest is: $simple_interest USD"
