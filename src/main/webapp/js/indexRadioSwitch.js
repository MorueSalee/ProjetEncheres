const achatsRadio = document.getElementById('achats_radio');
const ventesRadio = document.getElementById('ventes_radio');
const enchOpenCheckbox = document.getElementById('ench_open');
const myCurrentCheckbox = document.getElementById('ench_current');
const myWonCheckbox = document.getElementById('ench_won');
const myOngoingCheckbox = document.getElementById('vente_ongoing');
const salesNotStartedCheckbox = document.getElementById('vente_not_started');
const completedSalesCheckbox = document.getElementById('vente_completed');

achatsRadio.addEventListener('change', () => {
    enchOpenCheckbox.disabled = false;
    myCurrentCheckbox.disabled = false;
    myWonCheckbox.disabled = false;

    myOngoingCheckbox.disabled = true;
    salesNotStartedCheckbox.disabled = true;
    completedSalesCheckbox.disabled = true;
});

ventesRadio.addEventListener('change', () => {
    enchOpenCheckbox.disabled = true;
    myCurrentCheckbox.disabled = true;
    myWonCheckbox.disabled = true;

    myOngoingCheckbox.disabled = false;
    salesNotStartedCheckbox.disabled = false;
    completedSalesCheckbox.disabled = false;
});

