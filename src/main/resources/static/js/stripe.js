const stripe = Stripe('pk_test_51QliBePH79kVHzBmRCtXcV62wv7Le4ddqJLCqneMDX7gZVtSBJZl2mzwEaQtSdKXsXeaj1oQtDEDH54sHwdm74i5002zHfgKLt');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});